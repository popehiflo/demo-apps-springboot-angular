export class Producto {

  id?: number;
  producto: string;
  codigo: string;
  precio: number;

  constructor(producto: string, codigo: string, precio: number) {

    this.producto = producto;
    this.codigo = codigo;
    this.precio = precio;
  }

}


