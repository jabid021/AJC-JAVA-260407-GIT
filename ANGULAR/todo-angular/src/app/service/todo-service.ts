import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class TodoService {
  public demo: string = "La valeur";

  maMethodeA() {
    console.log("Qui fait un truc hyper compliqué");
  }
}
