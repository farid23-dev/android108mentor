package az.tutorials.mentor108android

data class PaginatedProductResponse(
	val total: Int? = null,
	val limit: Int? = null,
	val skip: Int? = null,
	val products: List<ProductsItem?>? = null
)

data class ProductsItem(
	val price: Any? = null,
	val id: Int? = null,
	val title: String? = null
)

