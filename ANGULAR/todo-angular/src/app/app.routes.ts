import { Routes } from '@angular/router';
import { HomePage } from './page/home-page/home-page';
import { TodoList } from './page/todo-list/todo-list';
import { TodoDetail } from './page/todo-detail/todo-detail';
import { DemoObservablePage } from './page/demo-observable-page/demo-observable-page';

export const routes: Routes = [
  { path: '', component: HomePage },
  { path: 'todos', component: TodoList },
  { path: 'todos/:id', component: TodoDetail },
  { path: 'observable', component: DemoObservablePage }
];
