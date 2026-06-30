import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Matiere } from '../model/matiere';

@Injectable({
  providedIn: 'root',
})
export class MatiereService {
  private http: HttpClient = inject(HttpClient);

  public findAll(): Observable<Matiere[]> {
    return this.http.get<Matiere[]>('http://localhost:8080/api/matiere');
  }

  public add(matiere: Matiere): Observable<Matiere> {
    return this.http.post<Matiere>('http://localhost:8080/api/matiere', matiere);
  }

  public update(matiere: Matiere): Observable<Matiere> {
    return this.http.put<Matiere>(`http://localhost:8080/api/matiere/${ matiere.id }`, matiere);
  }

  public remove(matiere: Matiere): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/api/matiere/${ matiere.id }`);
  }
}
