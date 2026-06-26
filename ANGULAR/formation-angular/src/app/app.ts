import { CommonModule } from '@angular/common';
import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Todo } from './model/todo';


@Component({
  selector: 'app-root',
  imports: [ FormsModule, CommonModule ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title: string = 'Formation Angular AJC';
  protected couleur: string = "black";
  protected todo: Todo = { id: 1, title: "Le titre", completed: false };
  protected demoBoolean: boolean = false;
  protected demoFor: string[] = [ "Chaine A", "Chaine B", "Chaine C", "Chaine D" ];

  public changeTitle() {
    this.title = "Le nouveau titre";
  }
}
