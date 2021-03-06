package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.models.Role;
import com.lambdaschool.usermodel.repository.RoleRepository;
import com.lambdaschool.usermodel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements the RoleService Interface
 */
@Transactional
@Service(value = "roleService")
public class RoleServiceImpl
        implements RoleService
{
    /**
     * Connects this service to the Role Model
     */
    @Autowired
    RoleRepository rolerepos;

    /**
     * Connect this service to the User Model
     */
    @Autowired
    UserRepository userrepos;

    @Autowired
    UserAuditing userAuditing;

    @Override
    public List<Role> findAll()
    {
        List<Role> list = new ArrayList<>();
        /*
         * findAll returns an iterator set.
         * iterate over the iterator set and add each element to an array list.
         */
        rolerepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }


    @Override
    public Role findRoleById(long id)
    {
        return rolerepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role id " + id + " not found!"));
    }

    @Override
    public Role findByName(String name)
    {
        Role rr = rolerepos.findByNameIgnoreCase(name);

        if (rr != null)
        {
            return rr;
        } else
        {
            throw new EntityNotFoundException(name);
        }
    }

    @Transactional
    @Override
    public Role save(Role role)
    {
        if (role.getUsers()
                .size() > 0)
        {
            throw new EntityExistsException("User Roles are not updated through Role.");
        }

        return rolerepos.save(role);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void deleteAll()
    { 
        rolerepos.deleteAll();
    }

    @Override
    public Role updateRoleName(long roleid, Role role) {
        rolerepos.findById(roleid)
            .orElseThrow(() -> new EntityNotFoundException("Role " + roleid + " not found!"));
        rolerepos.updateRoleName(roleid, role.getName(), userAuditing.getCurrentAuditor().get());
        
        return rolerepos.findById(roleid).get();
    }
}
