import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-root',
  imports: [ FormsModule ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title: string = 'Formation Angular AJC';

  public changeTitle() {
    this.title = "Le nouveau titre";
  }
}
