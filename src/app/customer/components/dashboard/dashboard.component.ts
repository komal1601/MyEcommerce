import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AdminService } from '../../../service/admin.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {

  products: any[] = [];
  searchProductForm!: FormGroup;
  snackBar: any;

  constructor(private adminService: AdminService,
    private fb: FormBuilder){}
  
  ngOnInit(){
    this.getAllProducts();
    this.searchProductForm = this.fb.group({
      title:[null, [Validators.required]]
    });
   
  }
  
  getAllProducts(){
    this.products = [];
    const title = this.searchProductForm.get('title')!.value;
    this.adminService.getAllProducts().subscribe(res => {
      res.forEach(element => {
        element.processedImg = 'data:image/jpeg;base64,' + element.byteImg;
        this.products.push(element);        
      });
      console.log(this.products)
    })  
  }

  submitForm(){

    this.products = [];
    const title = this.searchProductForm.get('title')!.value;
    this.adminService.getAllProductsByName(title).subscribe(res => {
      res.forEach(element => {
        element.processImg = 'data:image/jpeg;base64,' + element.byteImg;
        this.products.push(element);
      });
      console.log(this.products)

    })

  }

  addToCart(id:any) {
    this.customerService.addToCart(id).subscribe(res => {
      this.snackBar.open("Product added to cart successfully", "close", { durattion : 5000})
    })
  }

}
