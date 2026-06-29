import { Routes } from '@angular/router';
import { HomePage } from './page/home-page/home-page';
import { TodoList } from './page/todo-list/todo-list';

export const routes: Routes = [
  { path: '', component: HomePage },
  { path: 'todos', component: TodoList }
];
