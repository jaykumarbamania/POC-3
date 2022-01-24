export class User{
    id:number;
    name:string;
    surname:string;
    email:string;
    phone:string;
    pincode:string;
    active:string;
    dob:Date;
    joiningdate:Date;
    constructor(
        name:string,
        surname:string,
        email:string,
        phone:string,
        pincode:string,
        dob:Date,
        joiningdate:Date
    ){
        this.name = name;
        this.surname = surname;
        this.email = email
        this.phone = phone;
        this.pincode = pincode;
        this.active = "yes"
        this.dob = dob;
        this.joiningdate = joiningdate;
    }
}