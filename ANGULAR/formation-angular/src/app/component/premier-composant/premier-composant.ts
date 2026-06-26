import { Component, HostListener, Input, OnDestroy, OnInit } from '@angular/core';

@Component({
  selector: 'app-premier-composant',
  imports: [],
  templateUrl: './premier-composant.html',
  styleUrl: './premier-composant.css',
})
export class PremierComposant implements OnInit, OnDestroy {
  @Input('prenom')
  public prenom: string = "Zoro";

  @HostListener('click')
  public onClick() {
    alert('ok');
  }

  // Méthode qui va être déclenchée par Angular au moment où le composant sera initialisé !
  ngOnInit(): void {
    console.log("Initialisation du composant !");
  }

  // Méthode qui va être déclenchée par Angular au moment où le composant sera détruit !
  ngOnDestroy(): void {
    console.log("Destruction du composant !")
  }
}
