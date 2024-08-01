import { Component } from '@angular/core';
import { AdminService } from '../../../service/admin.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

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

  deleteProduct(productId:any){
    this.adminService.deleteProduct(productId).subscribe(res => {
      if(res.body == null ){
        this.snackBar.open('Product Deletd Successfully ..!!','close', {
          duration : 5000
        });
        this.getAllProducts();
      }
      else {
        this.snackBar.open(res.message, 'close', {
          duration: 5000,
          panelClass: 'error-snackBar'
        });
      }
    })

  }

}
