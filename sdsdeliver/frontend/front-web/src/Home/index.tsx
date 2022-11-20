import './styles.css';
import {ReactComponent as MainImage} from './main.svg';

function Home(){
    return (
        <div className="home-container">
            <div className="home-content">
                <div className="home-actions">
                    <h1 className="home-title">
                        Faça seu pedido<br/>
                            que entregamos<br/>
                            para você!                         
                    </h1>
                    <h3 className="home-subtitle">
                        Escolha seu produto, em poucos<br/>
                        levaremos em sua  porta!
                    </h3>
                    <a href="orders" className="home-btn-order">FAZER PEDIDO</a>
                </div>
                <MainImage/>
            </div>
        </div>
    )
}
export default Home;