package com.example.freefire.service;

import com.example.freefire.dto.ItemDTO;
import com.example.freefire.entity.Item;
import com.example.freefire.repository.ItemRepository;
import com.example.freefire.utils.UploadUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
@Service
public class ItemService implements IItemService{

    private static String outdir=System.getProperty("user.dir")+"/upload";
    final private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item save(ItemDTO itemDTO) {
        ModelMapper modelMapper= new ModelMapper();
        Item item=modelMapper.map(itemDTO,Item.class);

        if(itemDTO.getId()!=null){
            Item temp=itemRepository.findById(itemDTO.getId()).get();
            if(temp.getFileName()!=null){
                item.setFileName(temp.getFileName());
            }
            else {
                if(itemDTO.getMultipartFile().getSize()>0){

                    File file= new File(outdir,temp.getFileName());
                    file.delete();
                    item.setFileName(null);
                }
            }
        }

        if (itemDTO.getMultipartFile().getSize()>0){
            try {

                item.setFileName(UploadUtils.upload(itemDTO.getMultipartFile(),outdir));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return itemRepository.save(item);
    }

    @Override
    public Item getById(Integer id) {
        return itemRepository.findById(id).get();
    }

    @Override
    public ItemDTO getItemDTOById(Integer id) {
        Item item=itemRepository.findById(id).get();
        ModelMapper modelMapper= new ModelMapper();
        ItemDTO itemDTO=modelMapper.map(item,ItemDTO.class);
        return itemDTO;
    }

    @Override
    public void deleteById(Integer id) {
        Item item= itemRepository.findById(id).get();
        File file= new File(outdir,item.getFileName());
        file.delete();
        itemRepository.deleteById(id);
    }

    @Override
    public List<Item> findEnable() {
        return itemRepository.findByEnabled("0");
    }
}
