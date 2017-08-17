import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { Acao } from './acao';

@Injectable()
export class AcaoService {

    private headers = new Headers({ 'Content-Type': 'application/json' });
    private acoesUrl = 'http://localhost:8080/acoes';  // URL to web api

    constructor(private http: Http) { }

    getAcoes(): Observable<Acao[]> {
        return this.http.get(this.acoesUrl).map(res => res.json());
    }

}
