# Design decisions

* I have placed the business logic layer and the web layer in the same module. Ideally they should be in different modules so other APIs/ services can reuse the business logic
* All APIs have been versioned.
* Different layers - apis, service, validators, repositories are maintained as different layers with their own models.

# Scope of improvements
* Add Loggers and metric reporters 
* Add Swaggers for API documentations 
* Add Tests for API contracts. This will help us when there is a breaking contract change in request/ response.