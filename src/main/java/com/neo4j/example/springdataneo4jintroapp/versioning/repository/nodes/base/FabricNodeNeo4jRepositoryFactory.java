package com.neo4j.example.springdataneo4jintroapp.versioning.repository.nodes.base;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.util.service.FabricKeyService;
import org.neo4j.ogm.session.Session;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.neo4j.mapping.Neo4jPersistentEntity;
import org.springframework.data.neo4j.mapping.Neo4jPersistentProperty;
import org.springframework.data.neo4j.repository.support.Neo4jRepositoryFactory;
import org.springframework.data.repository.core.RepositoryInformation;

public class FabricNodeNeo4jRepositoryFactory extends Neo4jRepositoryFactory {

    private final Session session;
    private final FabricKeyService fabricKeyService;

    public FabricNodeNeo4jRepositoryFactory(final Session session,
                                            final MappingContext<Neo4jPersistentEntity<?>, Neo4jPersistentProperty> mappingContext,
                                            final FabricKeyService fabricKeyService) {
        super(session, mappingContext);
        this.session = session;
        this.fabricKeyService = fabricKeyService;
    }

    @Override
    protected Object getTargetRepository(final RepositoryInformation information) {
        return this.getTargetRepositoryViaReflection(information,
                information.getDomainType(), this.session, this.fabricKeyService);
    }
}