import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'ajc-navigation',
  imports: [ RouterLink ],
  templateUrl: './navigation.html',
  styleUrl: './navigation.css',
})
export class Navigation {}
