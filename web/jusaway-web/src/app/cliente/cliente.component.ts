import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['../app.component.css']
})

export class ClienteComponent implements OnInit {

  tipo: string;

  constructor() { }

  ngOnInit() {
  }

  onSubmit(formCliente: NgForm) {
  }

}
