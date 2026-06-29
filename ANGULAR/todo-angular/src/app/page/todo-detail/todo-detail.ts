import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-todo-detail',
  imports: [],
  templateUrl: './todo-detail.html',
  styleUrl: './todo-detail.css',
})
export class TodoDetail implements OnInit {
  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      console.log(params);
    });
  }
}
