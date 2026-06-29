import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { DemoPipe } from '../../pipe/demo-pipe';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-home-page',
  imports: [
    CommonModule,
    DemoPipe
  ],
  templateUrl: './home-page.html',
  styleUrl: './home-page.css',
})
export class HomePage implements OnInit {
  protected prenom: string = "jeremy";

  constructor(private title: Title) {
    // this.title.setTitle("Accueil");
  }

  ngOnInit(): void {
    this.title.setTitle("Accueil");
  }
}
