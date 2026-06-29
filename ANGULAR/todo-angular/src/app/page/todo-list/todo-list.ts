import { Component, inject, OnInit } from '@angular/core';
import { Todo } from '../../model/todo';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { TodoStatePipe } from '../../pipe/todo-state-pipe';
import { Title } from '@angular/platform-browser';
import { TodoService } from '../../service/todo-service';

@Component({
  selector: 'app-todo-list',
  imports: [
    FormsModule,
    CommonModule,
    TodoStatePipe
  ],
  templateUrl: './todo-list.html',
  styleUrl: './todo-list.css',
})
export class TodoList implements OnInit {
  protected formTodo: Todo = { id: 0, title: "", completed: false };
  // protected todos: Array<Todo> = []
  protected todos!: Todo[];

  // Injection avec "inject", dans la classe
  private route: ActivatedRoute = inject(ActivatedRoute);
  private title: Title = inject(Title);
  protected todoService: TodoService = inject(TodoService);

  // Injection par constructeur
  // constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    // Injection avec "inject", dans une fonction
    // const laRoute = inject(ActivatedRoute);

    this.route.queryParams.subscribe(params => {
      console.log(params);
      console.log(params['demo']);
    });

    this.title.setTitle("Liste des Todos");
    this.todos = this.todoService.findAll();
  }

  public ajouterTodo() {
    // this.todos.push({ ...this.formTodo });
    // this.formTodo.id = 0;
    // this.formTodo.title = "";
    // this.formTodo.completed = false;

    // this.todos.push(this.formTodo);
    this.todoService.add(this.formTodo);
    this.formTodo = { id: 0, title: "", completed: false };
  }

  public supprimerTodo(todo: Todo) {
    this.todoService.remove(todo);
  }
}
