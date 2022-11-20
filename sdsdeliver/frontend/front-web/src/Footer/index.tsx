import './styles.css';
import {ReactComponent as Youtube} from './youtube.svg';
import {ReactComponent as Instagram} from './instagram.svg';
import {ReactComponent as Linkedin} from './linkedin.svg';

function Footer(){
    return (
        <footer className="main-footer">
            App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
            <div>
                <a href="https://www.youtube.com/c/JoneySousa/about" target="">
                    <Youtube />
                </a>
                <a href="https://www.instagram.com/joneysousapereira/" target="">
                    <Instagram />
                </a>
                <a href="https://www.linkedin.com/in/joney-sousa-pereira-347aaa30/" target="">
                    <Linkedin />
                </a>
            </div>
        </footer>
    )
}
export default Footer;