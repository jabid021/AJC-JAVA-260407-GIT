import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-premier-composant',
  imports: [],
  templateUrl: './premier-composant.html',
  styleUrl: './premier-composant.css',
})
export class PremierComposant {
  @Input('prenom')
  public prenom: string = "Zoro";
}
