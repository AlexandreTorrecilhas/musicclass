import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Pessoa {
  constructor(private http: HttpClient) {}

  // This method sends the "Map" (the JSON) to your Java Backend
  enviarDados(url: string, dados: any): Observable<any> {
    return this.http.post(url, dados);
  }
}
