> [!IMPORTANT]
> THIS REPOSITORY IS DEPRECATED.
>
> Development on this webservice has been moved to: [https://github.com/identifiers-org/monorepo](https://github.com/identifiers-org/monorepo/tree/master/webservices/resource-recommender).
> This new repository targets easier code integration and facilitated CI/CD pipeline. For any concerns, please [contact us](https://docs.identifiers.org/pages/contact) or open a issue at our [main issue board](https://github.com/identifiers-org/identifiers-org.github.io/issues).


# Overview
This Web Service implements recommendations / scoring for _resolved resources_ computed by [identifiers.org](https://identifiers.org) _Resolution Service_.


## Scoring Strategy and Meaning
In this iteration of the service, its scoring strategy it is based on preference information
about every particular _resolved resource_, and how it relates to the other _resolved
resource_ candidates.

The score is any integer between '0' and '99', being '99' the scoring of a highly recommended
_resolved resource_.


## How to get scoring data from this service
Scoring information is obtained via the Compact ID _Resolution Service_, when it resolves a
Compact ID into a list of providers, a.k.a. _resolved resources_.


### Contact
Manuel Bernal Llinares
