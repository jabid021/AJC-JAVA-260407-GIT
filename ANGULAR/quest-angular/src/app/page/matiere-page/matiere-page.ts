import { Component, inject, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Observable, startWith, Subject, switchMap } from 'rxjs';
import { Matiere } from '../../model/matiere';
import { MatiereService } from '../../service/matiere-service';
import { AsyncPipe, CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-matiere-page',
  imports: [ CommonModule, FormsModule ],
  templateUrl: './matiere-page.html',
  styleUrl: './matiere-page.css',
})
export class MatierePage implements OnInit {
  private titleService: Title = inject(Title);
  private matiereService: MatiereService = inject(MatiereService);

  private refresh$: Subject<void> = new Subject<void>();
  protected matieres$!: Observable<Matiere[]>;
  protected formMatiere!: Matiere;

  ngOnInit(): void {
    this.titleService.setTitle("Liste des matières");

    this.formMatiere = { libelle: "" };

    this.matieres$ = this.refresh$.pipe(
      startWith(0), // Initialisation => forcer le chargement une première fois
      switchMap(() => this.matiereService.findAll()) // Transformer au moment du next()
    );
  }

  private reload() {
    this.refresh$.next();
  }

  protected addOrUpdate() {
    if (this.formMatiere.id) {
      this.matiereService.update(this.formMatiere).subscribe(() => this.reload());
    }

    else {
      this.matiereService.add(this.formMatiere).subscribe(() => this.reload());
    }

    this.formMatiere = { libelle: "" };
  }

  protected edit(matiere: Matiere) {
    this.formMatiere = { ...matiere };
  }

  protected remove(matiere: Matiere) {
    this.matiereService.remove(matiere).subscribe(() => this.reload());
  }
}
