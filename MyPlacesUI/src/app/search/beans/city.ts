export class City {

  private _city: string;
  private _province: string;
  private _country: string;
  
  public get city(): string {
    return this._city;
  }
  public set city(value: string) {
    this._city = value;
  }

  public get province(): string {
    return this._province;
  }
  public set province(value: string) {
    this._province = value;
  }

  public get country(): string {
    return this._country;
  }
  public set country(value: string) {
    this._country = value;
  }

}