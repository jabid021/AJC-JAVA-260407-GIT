import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Todo } from '../../model/todo';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-demo-http-page',
  imports: [ CommonModule ],
  templateUrl: './demo-http-page.html',
  styleUrl: './demo-http-page.css',
})
export class DemoHttpPage implements OnInit {
  // protected todos!: Todo[];
  protected todos$!: Observable<Todo[]>;

  constructor(private http: HttpClient) {

  }

  ngOnInit(): void {

    // this.http.get<Todo[]>('https://jsonplaceholder.typicode.com/todos').subscribe(todos => {
    //   // console.log(todos);
    //   this.todos = todos;
    // });

    this.todos$ = this.http.get<Todo[]>('https://jsonplaceholder.typicode.com/todos');

  }

}
