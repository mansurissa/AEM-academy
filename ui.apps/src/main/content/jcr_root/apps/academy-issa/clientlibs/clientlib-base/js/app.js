const productList = document.querySelector('.productsList');

fetch('http://localhost:4502/bin/products')
  .then((res) => res.json())
  .then((products) => {
  products.forEach(product=>{

    productList.innerHTML += `  <div class="col-sm-4">
      <div class="card">
        <div class="card-body">
          <img src="${product.image}" alt="product image" />
          <h5 class="card-title">${product.name}</h5>
          <p class="card-text">${product.Description}</p>

          <a href="/content/academy-issa/us/en/home-page/${product.name.split(' ')[0]}-${product.name.split(' ')[1]}.html" class="btn btn-primary">More Details</a>
        </div>
      </div>
    </div>`;
  })

  });