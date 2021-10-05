import { CategoryTO } from "./category-t-o";

export class ProductTO {
  constructor(
    id: number,
    name: string,
    description: string,
    price: number,
    stock: number,
    category: CategoryTO
  ) {
  }
}
