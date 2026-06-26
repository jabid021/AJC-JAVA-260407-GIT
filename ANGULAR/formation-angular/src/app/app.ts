import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title: string = 'Formation Angular AJC';

  public changeTitle() {
    this.title = "Le nouveau titre";
  }

  public updateTitle(event: any) {
    this.title = event.target.value;
  }
}
