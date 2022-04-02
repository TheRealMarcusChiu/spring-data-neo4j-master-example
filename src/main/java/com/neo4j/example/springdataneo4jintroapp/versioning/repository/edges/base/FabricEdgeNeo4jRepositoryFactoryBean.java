package com.neo4j.example.springdataneo4jintroapp.versioning.repository.edges.base;

import com.neo4j.example.springdataneo4jintroapp.versioning.model.util.service.FabricKeyService;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.neo4j.mapping.Neo4jMappingContext;
import org.springframework.data.neo4j.repository.support.Neo4jRepositoryFactoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import java.io.Serializable;

public class FabricEdgeNeo4jRepositoryFactoryBean<T extends Repository<S, ID>, S, ID extends Serializable>
        extends Neo4jRepositoryFactoryBean<T, S, ID> {

    @Autowired
    private FabricKeyService fabricKeyService;
    private Neo4jMappingContext mappingContext;

    public FabricEdgeNeo4jRepositoryFactoryBean(final Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    public void setMappingContext(final MappingContext<?, ?> mappingContext) {
        super.setMappingContext(mappingContext);
        if (mappingContext instanceof Neo4jMappingContext) {
            this.mappingContext = (Neo4jMappingContext) mappingContext;
        }
    }

    /**
     * @deprecated
     * @param session Neo4j session
     * @return RepositoryFactorySupport
     */
    @Override
    protected RepositoryFactorySupport createRepositoryFactory(final Session session) {
        return new FabricEdgeNeo4jRepositoryFactory(session, this.mappingContext, fabricKeyService);
    }
}
