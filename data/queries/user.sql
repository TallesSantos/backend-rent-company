select * from [user] as u
	left join address as ad on ad.user_id = u.id
	left join phone as phone on phone.user_id = u.id
	left join user_permission as up on up.user_id = u.id
	left join permission as perm on perm.id = up.permission_id
