import { CommonModule } from '@angular/common';
import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { Observable, startWith, Subject, switchMap } from 'rxjs';
import { Matiere } from '../../model/matiere';
import { MatiereService } from '../../service/matiere-service';

@Component({
  selector: 'app-matiere-page',
  imports: [ CommonModule, ReactiveFormsModule ],
  templateUrl: './matiere-page.html',
  styleUrl: './matiere-page.css',
})
export class MatierePage implements OnInit {
  private titleService: Title = inject(Title);
  private matiereService: MatiereService = inject(MatiereService);

  private refresh$: Subject<void> = new Subject<void>();
  protected matieres$!: Observable<Matiere[]>;

  // Reactive Forms
  private formBuilder: FormBuilder = inject(FormBuilder);
  protected formMatiere!: FormGroup;
  protected formCtrlLibelle!: FormControl;
  protected editingMatiereId: number | undefined = 0;

  ngOnInit(): void {
    this.titleService.setTitle("Liste des matières");

    this.matieres$ = this.refresh$.pipe(
      startWith(0), // Initialisation => forcer le chargement une première fois
      switchMap(() => this.matiereService.findAll()) // Transformer au moment du next()
    );

    // Reactive Form
    this.formCtrlLibelle = this.formBuilder.control('', Validators.required);

    this.formMatiere = this.formBuilder.group({
      // Ajout des différents contrôles == input, select, etc.
      // libelle: this.formBuilder.control('', Validators.required)
      libelle: this.formCtrlLibelle
    });
  }

  private reload() {
    this.refresh$.next();
  }

  protected addOrUpdate() {
    // const matiere: Matiere = {
    //   libelle: this.formCtrlLibelle.value
    // };

    const matiere: Matiere = this.formMatiere.getRawValue();

    if (this.editingMatiereId) {
      matiere.id = this.editingMatiereId;
      this.matiereService.update(matiere).subscribe(() => this.reload());
    }

    else {
      this.matiereService.add(matiere).subscribe(() => this.reload());
    }

    this.formMatiere.reset();
    this.editingMatiereId = 0;
  }

  protected edit(matiere: Matiere) {
    this.editingMatiereId = matiere.id;
    this.formCtrlLibelle.setValue(matiere.libelle);
  }

  protected remove(matiere: Matiere) {
    this.matiereService.remove(matiere).subscribe(() => this.reload());
  }
}
