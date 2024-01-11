select food_type, rest_id, rest_name, favorites
    from rest_info
    group by food_type;