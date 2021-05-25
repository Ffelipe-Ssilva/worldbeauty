class HeaderComponent extends HTMLElement {
    constructor(){
        super();
        let title =  this.getAttribute('header-text');
        let href =  this.getAttribute('href');

        this.innerHTML = `<h2 id="title">${title}</h2>`
    }
}
window.customElements.define('header-component', HeaderComponent);