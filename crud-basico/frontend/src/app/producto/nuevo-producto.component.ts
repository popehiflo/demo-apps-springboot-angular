import { Component, OnInit } from '@angular/core';
import { ProductoService } from '../service/producto.service';
import { Producto } from '../models/producto';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nuevo-producto',
  templateUrl: './nuevo-producto.component.html',
  styleUrls: ['./nuevo-producto.component.css']
})
export class NuevoProductoComponent implements OnInit {

  producto:string = '';
  codigo:string = '';
  precio:number = 0;

  constructor(private productoService: ProductoService,
              private toastr: ToastrService,
              private router: Router) { }

  ngOnInit(): void {
  }

  onCreate():void {
    const product = new Producto(this.producto, this.codigo, this.precio);
    this.productoService.save(product).subscribe(
      data => {
        this.toastr.success('Producto creado!', 'OK', {
          timeOut: 3000,
          positionClass: 'toast-top-center'
        });
        this.router.navigate(['/']);
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,
          positionClass: 'toast-top-center'
        });

      }

    )
    //this.router.navigate(['/']);
  }

}
