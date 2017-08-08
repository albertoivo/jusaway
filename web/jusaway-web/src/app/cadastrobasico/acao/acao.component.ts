import { Component, ElementRef, ViewChild, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
    selector: 'app-acao',
    templateUrl: './acao.component.html',
    styleUrls: ['../../app.component.css']
})

export class AcaoComponent implements OnInit {
    formAcao = new FormGroup({});
    displayedColumns = ['nome', 'descricao', 'acao'];
    @ViewChild('filter') filter: ElementRef;
    ngOnInit(): void {
        this.formAcao = new FormGroup({
            'nome': new FormControl(this.nome, [Validators.required, Validators.maxLength(30)]),
            'descricao': new FormControl(this.descricao, [Validators.maxLength(50)])
        });
    }
    get nome() { return this.formAcao.get('nome'); }
    get descricao() { return this.formAcao.get('descricao'); }

}
