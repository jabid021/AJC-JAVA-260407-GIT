import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { DemoPipe } from '../../pipe/demo-pipe';
import { Title } from '@angular/platform-browser';
import { TodoService } from '../../service/todo-service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home-page',
  imports: [
    FormsModule,
    CommonModule,
    DemoPipe
  ],
  templateUrl: './home-page.html',
  styleUrl: './home-page.css',
})
export class HomePage implements OnInit {
  protected prenom: string = "jeremy";
  // public demo: string = "La valeur";

  constructor(private title: Title, protected service: TodoService) {
    // this.title.setTitle("Accueil");

    service.maMethodeA();
  }

  ngOnInit(): void {
    this.service.maMethodeA();

    this.title.setTitle("Accueil");
  }
}
