import { Component } from '@angular/core';
import { Todo } from '../../model/todo';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-todo-list',
  imports: [ FormsModule, CommonModule ],
  templateUrl: './todo-list.html',
  styleUrl: './todo-list.css',
})
export class TodoList {
  protected formTodo: Todo = { id: 0, title: "", completed: false };
  // protected todos: Array<Todo> = []
  protected todos: Todo[] = [ ];

  public ajouterTodo() {
    // this.todos.push({ ...this.formTodo });
    // this.formTodo.id = 0;
    // this.formTodo.title = "";
    // this.formTodo.completed = false;

    this.todos.push(this.formTodo);
    this.formTodo = { id: 0, title: "", completed: false };
  }

  public supprimerTodo(todo: Todo) {
    const index = this.todos.indexOf(todo);

    this.todos.splice(index, 1);
  }
}
