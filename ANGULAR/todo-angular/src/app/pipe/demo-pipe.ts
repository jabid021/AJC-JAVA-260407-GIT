import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'demo',
})
export class DemoPipe implements PipeTransform {
  transform(value: string, ...args: unknown[]): string {
    return value + " => demonstration, " + args[0] + ", " + args[1];
  }
}
