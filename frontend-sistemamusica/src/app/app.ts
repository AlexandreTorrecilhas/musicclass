import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PageBorderComponent } from './components/pageborder/pageborder.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, PageBorderComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend-sistemamusica');
}
