import { Routes } from '@angular/router';
import { Index } from './pages/index';
import { Pessoas } from './pages/pessoas/pessoas';

export const routes: Routes = [
    {path: '', component: Index},
    {path: 'pessoas', component: Pessoas}
];
