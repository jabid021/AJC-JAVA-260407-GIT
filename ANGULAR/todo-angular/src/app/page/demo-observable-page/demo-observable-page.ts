import { Component, OnInit } from '@angular/core';
import { Observable, Subscription } from 'rxjs';

@Component({
  selector: 'app-demo-observable-page',
  imports: [],
  templateUrl: './demo-observable-page.html',
  styleUrl: './demo-observable-page.css',
})
export class DemoObservablePage implements OnInit {

  ngOnInit(): void {
    // Les promesses
    const prom = new Promise((resolve, error) => {

      setTimeout(() => {
        resolve(10); // <-- ici, y'aura la fonction contenue dans le .then()
      }, 1000);

    });

    console.log("Console log ici .... qui s'exécutera AVANT le console log de value ");

    // Le then s'exécute quand la promesse sera résolue
    prom.then(value => console.log(value));

    let obs = new Observable<number>(observer => {
      setTimeout(() => observer.next(1), 1000);
      setTimeout(() => observer.next(2), 2000);
      setTimeout(() => observer.next(3), 3000);
      setTimeout(() => observer.next(4), 4000);
      setTimeout(() => observer.next(5), 5000);
      setTimeout(() => observer.next(6), 6000);
    });

    console.log("Console log ici (2) .... qui s'exécutera AVANT le console log de value ");

    // obs.subscribe(console.log);
    const subs:Subscription = obs.subscribe(value => console.log(value));

    setTimeout(() => subs.unsubscribe(), 3000);
  }
}
