import { Injectable } from '@angular/core';
import { Todo } from '../model/todo';

@Injectable({
  providedIn: 'root',
})
export class TodoService {
  private todos: Todo[] = [];

  public findAll(): Todo[] {
    return this.todos;
  }

  public add(todo: Todo) {
    this.todos.push(todo);
  }

  public remove(todo: Todo) {
    this.todos.splice(this.todos.indexOf(todo), 1);
  }
}
