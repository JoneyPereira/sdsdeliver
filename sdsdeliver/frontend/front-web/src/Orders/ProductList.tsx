import ProcuctCard from "./ProductCard";
import { Product } from "./types";

type Props = {
    products: Product[];
}

function ProcuctList({ products }: Props){
    return (
       <div className="orders-list-container">
            <div className="orders-list-items">
                {products.map(product =>(
                    <ProcuctCard key={product.id} product={product} />
                ))}
            </div>        
       </div>
    )
}
export default ProcuctList;