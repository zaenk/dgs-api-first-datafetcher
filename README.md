# DSG API first approach

This project aims to be a proof of concept implementation for API first design workflow with [Netflix DGS](https://netflix.github.io/dgs/).

The ideal workflow would be:
- Define the GraphQL schema in a separate module or repository
- Build client and server packages from that module/repo and publish them (either is JARs, npm, tar, etc.)
- Pull the built server side GraphQL package as dependency and implement data fetcher interfaces

This approach requires the following things to be generated in the server side package:
- Annotated DTOs
- Annotated Data fetcher interfaces
