import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'todoState',
})
export class TodoStatePipe implements PipeTransform {
  transform(value: boolean, ...args: unknown[]): string {
    return value ? 'Terminé !' : 'Non terminé';
  }
}
