import { CommonModule } from '@angular/common';
import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-root',
  imports: [ FormsModule, CommonModule ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title: string = 'Formation Angular AJC';
  protected couleur: string = "black";

  public changeTitle() {
    this.title = "Le nouveau titre";
  }
}
