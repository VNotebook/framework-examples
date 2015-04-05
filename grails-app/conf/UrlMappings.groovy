class UrlMappings {

	static mappings = {
        "/generos"(resources: "genre")
        "/actores"(resources: "actor")

        /*"/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }*/

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
