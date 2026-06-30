import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Matiere } from '../model/matiere';

@Injectable({
  providedIn: 'root',
})
export class MatiereService {
  private http: HttpClient = inject(HttpClient);
  private apiUrl: string = '/matiere';

  public findAll(): Observable<Matiere[]> {
    return this.http.get<Matiere[]>(this.apiUrl);
  }

  public add(matiere: Matiere): Observable<Matiere> {
    return this.http.post<Matiere>(this.apiUrl, matiere);
  }

  public update(matiere: Matiere): Observable<Matiere> {
    return this.http.put<Matiere>(`${ this.apiUrl }/${ matiere.id }`, matiere);
  }

  public remove(matiere: Matiere): Observable<void> {
    return this.http.delete<void>(`${ this.apiUrl }/${ matiere.id }`);
  }
}
