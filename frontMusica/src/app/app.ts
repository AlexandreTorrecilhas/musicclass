import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AppPaginaMain } from './paginas/app-pagina-main';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, AppPaginaMain],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontMusica');
}
