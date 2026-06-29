import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { DemoPipe } from '../../pipe/demo-pipe';

@Component({
  selector: 'app-home-page',
  imports: [
    CommonModule,
    DemoPipe
  ],
  templateUrl: './home-page.html',
  styleUrl: './home-page.css',
})
export class HomePage {
  protected prenom: string = "jeremy";
}
